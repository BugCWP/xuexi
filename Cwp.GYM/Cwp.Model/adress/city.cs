using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.adress
{
    public class city
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public Guid? provinceid { get; set; }
        public string provincename { get; set; }
    }
}
