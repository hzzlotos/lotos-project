package javacore.distributed.javacore.rmi.activator;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This server program instantiates a remote warehouse object, registers it with the naming
 * service, and waits for clients to invoke methods.
 * 
 * @version 1.12 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseActivator
{
    // 首先启动rmid 命令如下
    // rmid
    // -J-Djava.security.policy=G:\\eclipse\\workspace\\exercise\\src\\main\\java\\javacore\\distributed\\javacore\\activator\\server.policy\\rmid.policy
    // -port 1099
    public static void main(String[] args) throws RemoteException, NamingException, ActivationException, IOException
    {
        System.out.println("Constructing activation descriptors...");
        LocateRegistry.createRegistry(1099);// 指定端口号
        Properties props = new Properties();
        // use the server.policy file in the current directory
        // props.put("java.security.policy", new File("server.policy").getCanonicalPath());
        ActivationGroupDesc group = new ActivationGroupDesc(props, null);
        ActivationGroupID id = ActivationGroup.getSystem().registerGroup(group);

        Map<String, Double> prices = new HashMap<String, Double>();
        prices.put("Blackwell Toaster", 24.95);
        prices.put("ZapXpress Microwave Oven", 49.95);

        MarshalledObject<Map<String, Double>> param = new MarshalledObject<Map<String, Double>>(prices);

        String codebase = "http://localhost:8080/";

        ActivationDesc desc = new ActivationDesc(id, "WarehouseImpl", codebase, param);

        Warehouse centralWarehouse = (Warehouse) Activatable.register(desc);

        System.out.println("Binding activable implementation to registry...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi:central_warehouse", centralWarehouse);
        System.out.println("Exiting...");
    }
}
