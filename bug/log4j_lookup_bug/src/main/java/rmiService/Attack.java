package rmiService;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * 被攻击端执行的程序
 */
public class Attack implements ObjectFactory {
    static {
        System.out.println("正在挖矿!");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return "哈哈";
    }
}
