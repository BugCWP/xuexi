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
        public Guid personid { get; set; }
        //职位
        public Guid stafflevlid { get; set; }
        //所在健身房
        public Guid gymid { get; set; }
        //入职时间
        public Guid entrytime { get; set; }
    }
}
