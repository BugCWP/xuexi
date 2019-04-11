using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model
{
    public class dataList<T>
    {
       public IEnumerable<T> list { get; set; }
       public string pageCount { get; set; }
       public string Count { get; set; }
    }
}
