using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntrustDemo
{
    class Program
    {
        static void Main()
        {
            //Employee[] employees =
            //{
            //    new Employee("Bug Bunny",20000),
            //    new Employee("Elmer Fudd",10000),
            //    new Employee("Daffy Duck",25000),
            //    new Employee("Wile Coyote",1000000.38m),
            //    new Employee("Foghorn Leghorn",23000),
            //    new Employee("RoadRunner",50000)
            //};
            //BubbleSorter.Sort(employees, Employee.ComparaSalary);
            //foreach (var employee in employees)
            //{
            //    Console.WriteLine(employee);
            //}
            //Console.ReadKey();


            //多播委托
            //Action<double> operations = MathOperations.MultiplyByTwo;
            //operations += MathOperations.Square;
            //ProcessAndDisplayNumber(operations, 2.0);
            //ProcessAndDisplayNumber(operations,7.94);
            //ProcessAndDisplayNumber(operations,1.414);
            //Console.ReadKey();


            //自己迭代方法列表以防方法报错停止迭代
            //Action d1 = one;
            //d1 += two;
            //Delegate[] delegates = d1.GetInvocationList();
            //foreach(Action d in delegates)
            //{
            //    try
            //    {
            //        d();
            //    }
            //    catch (Exception)
            //    {
            //        Console.WriteLine("Exception caught");
            //    }
            //}
            //Console.ReadKey();

            //匿名方法
            //string mid = ",middle part";
            //Func<string, string> anonDel = delegate (string param)
            //   {
            //       param += mid;
            //       param += "and this was added to the string";
            //       return param;
            //   };
            //Console.WriteLine(anonDel("Start of string"));
            //Console.ReadKey();


            //lambda表达式委托
            string mid = ",middle part,";
            Func<string, string> lambda = param =>
             {
                 param += mid;
                 param += " and this was added to the string.";
                 return param;
             };
            Console.WriteLine(lambda("Start of string"));
            Console.ReadKey();

        }

        static void ProcessAndDisplayNumber(Action<double> action,double value)
        {
            Console.WriteLine();
            Console.WriteLine("ProcessAndDisplayNumber called with value={0}",value);
            action(value);
        }

        static void one()
        {
            Console.WriteLine("one");
            throw new Exception("errar in one");
        }
        static void two()
        {
            Console.WriteLine("two");
        }
    }
}
