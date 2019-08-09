using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            IList<int> list1;
            IList<int> list2;
            
            for (int i=0;i<1000000;i++)
            {
                list.Add(i);
            }
            IEnumerable<int> listobj = list;
            Stopwatch watch = new Stopwatch();   //测试时间类
            watch.Start();
            list1= listobj.ToList();
            watch.Stop();
            Console.WriteLine("tolist类型转换时间：{0}", watch.Elapsed);
            
            watch.Reset();
            watch.Start();
            if (listobj is IEnumerable<int>)
            {
                list2 = (IList<int>)listobj;
            }
            watch.Stop();
            Console.WriteLine("强类型转换时间：            {0}", watch.Elapsed);
            Console.ReadKey();
        }
    }
}
