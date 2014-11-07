package cn.newtouch.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoOptions;
import com.mongodb.QueryOperators;

public class MongoDTest
{

    public static void main(String[] args)
    {

        // showDbTable();
        try
        {
            DB db = init("localhost", 27017, "test", "sysadmin", "admin001");
            DBCollection dbTable = getDBCollection(db, "testTable");
            searchTableAllData(dbTable);
            // add(dbTable);
            // remove(dbTable);
            // modify(dbTable);
            search(dbTable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static DB init(String host, int port, String dbName, String username, String password) throws Exception
    {
        Mongo mongo = new MongoClient(host, port);

        MongoOptions opt = mongo.getMongoOptions();

        opt.autoConnectRetry = false;
        opt.connectionsPerHost = 5000;
        opt.connectTimeout = 30000;
        opt.maxAutoConnectRetryTime = 0;
        opt.maxWaitTime = 120000;
        opt.socketKeepAlive = false;
        opt.socketTimeout = 30000;
        opt.threadsAllowedToBlockForConnectionMultiplier = 5;

        DB mdb = mongo.getDB("admin");
        if (!mdb.authenticate(username, password.toCharArray()))
        {
            throw new Exception();
        }
        mdb = mongo.getDB(dbName);
        return mdb;
    }

    private static void showDbTable()
    {
        try
        {
            DB db = init("localhost", 27017, "admin", "sysadmin", "admin001");

            for (String dbName : db.getMongo().getDatabaseNames())
            {
                System.out.println("============================");
                System.out.println("Mongo db name:" + dbName);
                for (String tableName : db.getMongo().getDB(dbName).getCollectionNames())
                {
                    System.out.println("-----------------------");
                    System.out.println("collectionName: " + tableName);
                    System.out.println("-----------------------");
                }
                System.out.println("============================");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static DBCollection getDBCollection(DB db, String tableName)
    {
        return db.getCollection(tableName);

    }

    private static void searchTableAllData(DBCollection table)
    {
        // 查询所有的数据
        DBCursor cur = table.find();
        while (cur.hasNext())
        {
            System.out.println(cur.next());
        }
        System.out.println("===============================");
    }

    // 添加
    public static void add(DBCollection dbTable)
    {
        // 第一种
        DBObject user = new BasicDBObject();
        user.put("name", "hoojo");
        user.put("age", 24);
        // table.save(user);// 保存，getN()获取影响行数
        System.out.println("save=====" + dbTable.save(user).getN());
        // 扩展字段，随意添加字段，不影响现有数据
        user.put("sex", "男");
        System.out.println("save==update===" + dbTable.save(user).getN());
        // 第二种
        System.out.println("insert=====" + dbTable.insert(new BasicDBObject("name", "tom")).getN());

        // 第三种
        // 添加List集合
        List<DBObject> list = new ArrayList<DBObject>();
        // 导入list的时候如果一条失败全部失败,不支持更新现有数据
        // user.put("nick", "bendan");
        // list.add(user);
        DBObject user2 = new BasicDBObject("name", "lucy");
        user.put("age", 22);
        list.add(user2);
        // 添加List集合
        System.out.println("insert==list===" + dbTable.insert(list).getN());

        // 查询下数据，看看是否添加成功
        System.out.println("count: " + dbTable.count());
        searchTableAllData(dbTable);
    }

    // 删除
    private static void remove(DBCollection dbTable)
    {
        System.out.println("删除id = 536100b282e140ed5fcbde3e："
                + dbTable.remove(new BasicDBObject("_id", new ObjectId("536100b282e140ed5fcbde3e"))).getN());
        System.out.println("remove name = tom : " + dbTable.remove(new BasicDBObject("name", "tom")).getN());
        System.out.println("remove age >= 24: "
                + dbTable.remove(new BasicDBObject("age", new BasicDBObject("$gte", 24))).getN());
    }

    // 修改
    private static void modify(DBCollection dbTable)
    {
        System.out.println("修改："
                + dbTable.update(new BasicDBObject("_id", new ObjectId("5361015682e129fa22180c14")),
                        new BasicDBObject("age", 99)).getN());
        System.out.println("修改："
                + dbTable.update(new BasicDBObject("name", "haha"), new BasicDBObject("name", "dingding"), false,// true表示如果数据不存在就添加,false表示不存在不添加
                        false// true表示存在多条不修改,false表示存在多条则修改第一条
                        ).getN());

        // 当数据库不存在就不修改、不添加数据，当多条数据就不修改
        // System.out.println("修改多条：" + coll.updateMulti(new BasicDBObject("_id", new
        // ObjectId("4dde23616be7c19df07db42c")), new
        // BasicDBObject("name", "199")));
        searchTableAllData(dbTable);
    }

    // 查询
    private static void search(DBCollection dbTable)
    {
        // 查询id = 4de73f7acd812d61b4626a77
        System.out.println("find id = 4de73f7acd812d61b4626a77: "
                + dbTable.find(new BasicDBObject("_id", new ObjectId("4de73f7acd812d61b4626a77"))).toArray());

        // 查询age = 24
        System.out.println("find age = 24: " + dbTable.find(new BasicDBObject("age", 24)).toArray());

        // 查询age >= 24
        System.out.println("find age >= 24: "
                + dbTable.find(new BasicDBObject("age", new BasicDBObject("$gte", 24))).toArray());
        // 查询age <= 24
        System.out.println("find age <= 24: "
                + dbTable.find(new BasicDBObject("age", new BasicDBObject("$lte", 24))).toArray());

        // 查询age != 25
        System.out.println("查询age!=25："
                + dbTable.find(new BasicDBObject("age", new BasicDBObject("$ne", 25))).toArray());

        // 查询 age in [24,25,26]
        System.out.println("查询age in 25/26/27："
                + dbTable
                        .find(new BasicDBObject("age", new BasicDBObject(QueryOperators.IN, new int[] { 25, 26, 27 })))
                        .toArray());

        // 查询 age not in [24,25,26]
        System.out.println("查询age not in 25/26/27："
                + dbTable.find(
                        new BasicDBObject("age", new BasicDBObject(QueryOperators.NIN, new int[] { 25, 26, 27 })))
                        .toArray());

        // 只查询一条数据，多条去第一条
        System.out.println("findOne: " + dbTable.findOne());
        System.out.println("findOne: " + dbTable.findOne(new BasicDBObject("age", 26)));
        System.out
                .println("findOne: " + dbTable.findOne(new BasicDBObject("age", 26), new BasicDBObject("name", true)));

        // 查询修改、删除
        System.out.println("findAndRemove 查询age=25的数据，并且删除: " + dbTable.findAndRemove(new BasicDBObject("age", 25)));

        // 查询age=26的数据，并且修改name的值为Abc
        System.out.println("findAndModify: "
                + dbTable.findAndModify(new BasicDBObject("age", 26), new BasicDBObject("name", "Abc")));
    }
}