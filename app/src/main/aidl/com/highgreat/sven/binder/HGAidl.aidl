// HGAidl.aidl
package com.highgreat.sven.binder;

// Declare any non-default types here with import statements
import com.highgreat.sven.binder.Person;

//服务端通过aidl接口暴露方法给客户端访问
interface HGAidl {
     void addPerson(in Person person);
     List<Person> getPersonList();
}
