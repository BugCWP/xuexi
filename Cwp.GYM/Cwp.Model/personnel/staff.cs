using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.personnel
{
    //店员
    public class staff:person
    {
        //职位
        public Guid? stafflevelid { get; set; }
        public string stafflevelname { get; set; }
        //所在健身房
        public Guid? gymid { get; set; }
        public string gymname { get; set; }
        //入职时间
        public string entrytime { get; set; }
    }
}
