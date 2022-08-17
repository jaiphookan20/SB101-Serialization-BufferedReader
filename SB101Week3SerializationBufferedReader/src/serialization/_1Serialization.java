package serialization;
import java.io.*;

import java.io.ObjectInputStream; //The ObjectInputStream is mainly used to read data written by the ObjectOutputStream.


import java.io.ObjectOutputStream;
//Basically, the ObjectOutputStream converts Java objects into corresponding streams. This is known as serialization. Those converted streams can be stored in files or transferred through networks.

//Now, if we need to read those objects, we will use the ObjectInputStream that will convert the streams back to corresponding objects. This is known as deserialization.

import java.io.Serializable;



/* 

What is Serialization in Java? 
Serialization in Java is the process of converting the Java code 
Object into a Byte Stream, to transfer the Object Code from one 
Java Virtual machine to another and recreate it using the 
process of Deserialization
 */

public class _1Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serialisation
        A object =new A();
        FileOutputStream fileOutputStream= new FileOutputStream("nio.txt");
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        System.out.println("object is serialized");


        // Deserialisation:
        FileInputStream fileInputStream= new FileInputStream("nio.txt");
        ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
        Object deserObject=objectInputStream.readObject();
        A deserializedObjectOfA=(A) deserObject;
        System.out.println("object is deserialized");
        System.out.println(deserializedObjectOfA.i);

        //we problem: the output of this?
        System.out.println(deserializedObjectOfA.email);
        System.out.println(deserializedObjectOfA.aBoolean);
       // objectOutputStream.writeObject("string");

        //be back by 2:50pm
    }
}


class A implements Serializable {
    int i=10;

    //don't serialize this
    transient String email="xyz@gmail.com";//null
    transient boolean aBoolean=true;
}