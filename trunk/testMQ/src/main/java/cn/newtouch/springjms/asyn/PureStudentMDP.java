package cn.newtouch.springjms.asyn;

import cn.newtouch.Student;

//Description: 纯POJO实现消息接收
public class PureStudentMDP
{
    // public void process(Map<String, Object> map)
    // {
    // Student student = new Student();
    // student.setName((String) map.get("key1"));
    // student.setAge((String) map.get("key2"));
    // System.out.println("PureStudentMDP:");
    // System.out.println(student.getName() + student.getAge());
    // }
    public void process(Student student)
    {
        System.out.println("PureStudentMDP:process(Student student)");
        System.out.println(student.getName() + "---" + student.getAge());
    }
}