//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: LoToS
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.Topic.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeToFlatFile
{
    public static void main(String[] args)
    {
        SerializeToFlatFile ser = new SerializeToFlatFile();
        ser.savePerson();
        ser.restorePerson();
    }

    public void savePerson()
    {
        Person myPerson = new Person("Jay", 24);
        try
        {
            FileOutputStream fos = new FileOutputStream("d:\\serialize.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Person--Jay,24---Written");
            System.out.println("Name is: " + myPerson.getName());
            System.out.println("Age is: " + myPerson.getAge());

            oos.writeObject(myPerson);
            oos.flush();
            oos.close();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void restorePerson()
    {
        try
        {
            FileInputStream fis = new FileInputStream("d:\\serialize.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person myPerson = (Person) ois.readObject();
            System.out.println("\n--------------------\n");
            System.out.println("Person--Jay,24---Restored");
            System.out.println("Name is: " + myPerson.getName());
            System.out.println("Age is: " + myPerson.getAge());
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
