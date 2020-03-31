package by.ginko.one;

import by.ginko.one.other_profession.SystemAdministrator;
import by.ginko.one.programmers.Junior;
import by.ginko.one.programmers.Senior;
import by.ginko.one.programmers.programmer;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DirectorTest2 {
    //@Ignore("Тест ещё не реализован!!!")

    @Test(groups={"util1"}, timeOut = 500)
    public void testCreate() {
        System.out.println("Тест testCreate");
        //Assert.fail("lox");
        //Assert.assertEquals(2*2,4);
        //Assert.assertTrue("Math error!",2 * 2 == 4 );
        //Assert.assertNull(testobj); отсутствие
        //Assert.assertSame(obj1, obj2); сравнение объектов
        //assertArrayEquals(int_arr1, int_arr2);
    }

    @Test(groups={"util1"})
    public void testGetProgrammerBySpecialization() {
        System.out.println("Тест testGetProgrammerBySpecialization");
        Junior q = new Junior("Vadim", 3, programmer.kind.Back_End);
        Senior q2 = new Senior("Dima", 3, programmer.kind.Front_End);
        SystemAdministrator q3 = new SystemAdministrator("Nik", 3);
        Director director = Director.Create();
        director.SetWorkers(q);
        director.SetWorkers(q2);
        director.SetWorkers(q3);
        var u = director.GetProgrammerBySpecialization(programmer.kind.Back_End);
        ArrayList<programmer> test = new ArrayList<programmer>();
        test.add(q);
        //вовращаемое значение не пустой массив
        Assert.assertEquals(u, test);
        //вовращаемое значение пустой массив
        u = director.GetProgrammerBySpecialization(programmer.kind.Full_Stack);
        test = new ArrayList<programmer>();
        Assert.assertEquals(u, test);
        director.lst = new ArrayList<>();
    }
    //@Test(dependsOnMethods={"testGetProgrammerBySpecialization"})
    @Test
    public void testSortByMoney() {
        System.out.println("Тест testSortByMoney");
        Junior q = new Junior("Vadim", 3, programmer.kind.Back_End);
        Senior q2 = new Senior("Dima", 3, programmer.kind.Front_End);
        SystemAdministrator q3 = new SystemAdministrator("Nik", 3);
        Director director = Director.Create();
        director.SetWorkers(q);
        director.SetWorkers(q2);
        director.SetWorkers(q3);

        int money = 1000;
        for (int i=0; i<director.lst.size(); i++)
        {
            var y = director.lst.get(i);
            y.money = money;
            money -= 100;
        }
        director.sortByMoney();
        List<Worker> lst= new ArrayList<Worker>();
        lst.add(q3);
        lst.add(q2);
        lst.add(q);
        Assert.assertEquals(director.lst, lst);
        director.lst = new ArrayList<>();
    }

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("аннотированный метод будет запущен до выполнения всех тестов в этом наборе");
    }
    @AfterSuite
    public void testAfterSuite() {
        System.out.println("Аннотированный метод будет запущен после выполнения всех тестов в этом наборе");
    }
    @AfterGroups("util1")
    public void testAfterGroups() {
        System.out.println("Список групп, после которых будет выполняться этот метод настройки. Этот метод гарантированно запускается вскоре после вызова последнего тестового метода, принадлежащего к любой из этих");
    }
}

//@BeforeSuite: Аннотированный метод будет запущен до выполнения всех тестов в этом наборе.
//@AfterSuite: Аннотированный метод будет запущен после выполнения всех тестов в этом наборе.
//@BeforeTest: Аннотированный метод будет запущен до запуска любого метода тестирования, принадлежащего классам внутри тега <test>.
//@AfterTest: Аннотированный метод будет запущен после выполнения всех методов тестирования, принадлежащих классам внутри тега <test>.
//@BeforeGroups: Список групп, для которых этот метод настройки будет выполняться ранее. Этот метод гарантированно запускается незадолго до вызова первого метода тестирования, принадлежащего к любой из этих групп.
//@AfterGroups: Список групп, после которых будет выполняться этот метод настройки. Этот метод гарантированно запускается вскоре после вызова последнего тестового метода, принадлежащего к любой из этих групп.
//@BeforeClass: Аннотированный метод будет запущен до того, как будет вызван первый тестовый метод в текущем классе.
//@AfterClass: Аннотированный метод будет запущен после выполнения всех методов тестирования в текущем классе.
//@BeforeMethod: Аннотированный метод будет выполняться перед каждым методом тестирования.
//@AfterMethod: Аннотированный метод будет выполняться после каждого метода тестирования.
//        Поведение аннотаций в суперклассе класса TestNG
//
//        Приведенные выше аннотации также будут учитываться (унаследованы) при размещении на a суперкласс класса TestNG. Это полезно, например, для централизации теста настройка для нескольких классов тестов в общем суперклассе.
//
//        В этом случае TestNG гарантирует, что методы" @Before " выполняются в порядок наследования (сначала высший суперкласс, а затем спускающийся по наследству цепочка), а также методы" @After " в обратном порядке (вверх по цепочке наследования).