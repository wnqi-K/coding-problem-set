/**
 * Author: Wenqiang Kuang
 * Date: 2018-07-04
 */

public class Problem1 {
    // This method is called lazy instantiation, singleton object is not
    // created until the first call.
    // 线程不安全
    public static class Singleton1{
        private static Singleton1 instance;
        public static Singleton1 getSingleton1(){
            if(instance == null){
                instance = new Singleton1();
            }
            return instance;
        }
    }

    // Do the instantiation beforehand, this is called Eager initialization.
    // 线程安全
    public static class Singleton2{
        private static Singleton2 instance = new Singleton2();
        public static Singleton2 getSingleton2(){
            return instance;
        }
    }

    // Ensure the process of getting instance is thread safe using 'synchronized'
    // Only one thread can enter the getSingleton3 method.
    // 线程安全，但是开销较大，比不加synchronized可能要慢上百倍。
    public static class Singleton3{
        private static Singleton3 instance;
        public synchronized static Singleton3 getSingleton3(){
            if(instance == null){
                instance = new Singleton3();
            }
            return instance;
        }
    }

    // Static block initialization.
    // 线程安全，方法和Singleton2相似，区别在于Singleton4把实例化放到了static block中。
    public static class Singleton4{
        private static Singleton4 instance;
        static{
            try{
                instance = new Singleton4();
            }catch(Exception e){
                throw new RuntimeException("Exception occur in creating singleton instance.");
            }
        }
        public static Singleton4 getSingleton4(){
            return instance;
        }
    }

    // Bill Pugh Singleton
    // 线程安全，通过一个inner static class实现，效率高，推荐。
    // 使用较广。
    public static class Singleton5{
        private static class SingletonHelper{
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        public static Singleton5 getSingleton5(){
            return SingletonHelper.INSTANCE;
        }
    }

    // Enum Singleton
    // 线程安全，推荐使用，缺点是不允许lazy initialization。
    public enum Singleton6{
        INSTANCE;

        public static void doSomething(){
            // do something.
        }
    }

    // Double checked locking.
    // 线程安全，volatile关键词，推荐。
    public static class Singleton7{
        private volatile static Singleton7 instance;
        public static Singleton7 getInstance(){
            if(instance == null){
                synchronized (Singleton7.class){
                    if(instance == null){
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getSingleton1() == Singleton1.getSingleton1());
        System.out.println(Singleton2.getSingleton2() == Singleton2.getSingleton2());
        System.out.println(Singleton3.getSingleton3() == Singleton3.getSingleton3());
        System.out.println(Singleton4.getSingleton4() == Singleton4.getSingleton4());
        System.out.println(Singleton5.getSingleton5() == Singleton5.getSingleton5());
        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }
}
