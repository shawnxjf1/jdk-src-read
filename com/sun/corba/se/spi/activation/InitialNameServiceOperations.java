package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/InitialNameServiceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u20/1074/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Wednesday, July 30, 2014 1:52:57 PM PDT
*/

public interface InitialNameServiceOperations 
{

  // bind initial name
  void bind (String name, org.omg.CORBA.Object obj, boolean isPersistant) throws com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;
} // interface InitialNameServiceOperations
