using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.adress
{
    public class city
    {
        public Guid id;
        public string name;
        public Guid provinceid { get; set; }
    }
}
