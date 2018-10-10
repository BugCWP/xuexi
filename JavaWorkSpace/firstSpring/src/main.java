import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        //创建一个spring的IOC容器对象
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWord helloWord=(HelloWord)context.getBean("helloword");
        helloWord.setName("spring");
        helloWord.sayhello();
    }
}
