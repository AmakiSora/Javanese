package designpattern.flyweight;

import java.util.HashMap;

/**
 * 手机系统工厂
 */
public class PhoneOSFactory {
    private final HashMap<String, PhoneOS> flyweights = new HashMap<>();

    PhoneOS getFlyweight(String internalSystem) {
        if (!flyweights.containsKey(internalSystem)) {
            PhoneOS phoneOS = new ConcretePhoneOS(internalSystem);
            flyweights.put(internalSystem, phoneOS);
        }
        return flyweights.get(internalSystem);
    }
}
