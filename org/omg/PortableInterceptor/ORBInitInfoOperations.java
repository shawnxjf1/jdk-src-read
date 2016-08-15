package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/ORBInitInfoOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u20/1074/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Wednesday, July 30, 2014 1:52:57 PM PDT
*/


/** 
   * Passed to each <code>ORBInitializer</code>, allowing it to
   * to register interceptors and perform other duties while the ORB is 
   * initializing.
   * <p>
   * The <code>ORBInitInfo</code> object is only valid during 
   * <code>ORB.init</code>.  If a service keeps a reference to its 
   * <code>ORBInitInfo</code> object and tries to use it after 
   * <code>ORB.init</code> returns, the object no longer exists and an 
   * <code>OBJECT_NOT_EXIST</code> exception shall be thrown.
   *
   * @see ORBInitializer
   */
public interface ORBInitInfoOperations 
{

  /** 
     * Returns the arguments passed to <code>ORB.init</code>.  They may or
     * may not contain the ORB's arguments.
     */
  String[] arguments ();

  /** 
     * Returns the ID of the ORB being initialized.
     */
  String orb_id ();

  /** 
     * Returns the <code>IOP.CodecFactory</code>. The 
     * <code>CodecFactory</code> is normally obtained via a call to 
     * <code>ORB.resolve_initial_references( "CodecFactory" )</code>, but 
     * since the ORB is not yet available and Interceptors, particularly when 
     * processing service contexts, will require a <code>Codec</code>, a 
     * means of obtaining a <code>Codec</code> is necessary during ORB 
     * initialization.
     */
  org.omg.IOP.CodecFactory codec_factory ();

  /** 
     * Identical to <code>ORB.register_initial_reference</code>. This same 
     * functionality exists here because the ORB, not yet fully initialized, 
     * is not yet available but initial references may need to be 
     * registered as part of Interceptor registration. The only difference 
     * is that the version of this operation on the ORB uses PIDL 
     * (<code>CORBA.ORB.ObjectId</code>) and 
     * (<code>CORBA.ORB.InvalidName</code>) whereas the version in this 
     * interface uses IDL defined in this interface; the semantics are 
     * identical.
     */
  void register_initial_reference (String id, org.omg.CORBA.Object obj) throws org.omg.PortableInterceptor.ORBInitInfoPackage.InvalidName;

  /**
     * Identical to <code>ORB.resolve_initial_references</code>. This same 
     * functionality exists here because the ORB, not yet fully initialized, 
     * is not yet available but initial references may be required from the 
     * ORB as part of Interceptor registration. The only difference is that 
     * the version of this operation on the ORB uses PIDL 
     * (<code>CORBA::ORB::ObjectId</code> and 
     * <code>CORBA::ORB::InvalidName</code>) whereas the version in this 
     * interface uses IDL defined in this interface; the semantics 
     * are identical.
     * <p>
     * This operation is only valid during post_init.
     */
  org.omg.CORBA.Object resolve_initial_references (String id) throws org.omg.PortableInterceptor.ORBInitInfoPackage.InvalidName;

  /**
     * Used to add a client-side request Interceptor to the list of 
     * client-side request Interceptors.  
     *
     * @param interceptor The <code>ClientRequestInterceptor</code> to be 
     *     added.
     * @exception DuplicateName thrown if a client-side request Interceptor 
     *     has already been registered with this Interceptor's name.
     */
  void add_client_request_interceptor (org.omg.PortableInterceptor.ClientRequestInterceptor interceptor) throws org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

  /** 
     * Used to add a server-side request Interceptor to the list of 
     * server-side request Interceptors.
     *
     * @param interceptor The ServerRequestInterceptor to be added.
     * @exception DuplicateName thrown if a server-side request Interceptor 
     *     has already been registered with this Interceptor's name
     */
  void add_server_request_interceptor (org.omg.PortableInterceptor.ServerRequestInterceptor interceptor) throws org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

  /**
     * Used to add an IOR Interceptor to the list of IOR Interceptors. 
     *
     * @param interceptor The IORInterceptor to be added.
     * @exception DuplicateName thrown if an IOR Interceptor has already 
     *     been registered with this Interceptor's name. 
     */
  void add_ior_interceptor (org.omg.PortableInterceptor.IORInterceptor interceptor) throws org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

  /**
     * Called to allocate a slot on <code>PortableInterceptor.Current</code>. 
     * <p>
     * Note that while slot id's can be allocated within an ORB initializer, 
     * the slots themselves cannot be initialized. 
     *
     * @return The index to the slot which has been allocated.
     * @exception BAD_INV_ORDER thrown, with a standard minor code of 14, if 
     *     <code>set_slot</code> or <code>get_slot</code> is called on the 
     *     <code>PICurrent</code> within an ORB initializer. 
     * @see Current
     */
  int allocate_slot_id ();

  /**
     * Registers a <code>PolicyFactory</code> for the given 
     * <code>PolicyType</code>. 
     * 
     * @param type The policy type that the given <code>PolicyFactory</code> 
     *     serves. 
     * @param policy_factory The factory for the given policy type.
     * @exception BAD_INV_ORDER thrown, with a standard minor code of 16, if 
     *     a <code>PolicyFactory</code> already exists for the given 
     *     <code>PolicyType</code>.
     */
  void register_policy_factory (int type, org.omg.PortableInterceptor.PolicyFactory policy_factory);
} // interface ORBInitInfoOperations
