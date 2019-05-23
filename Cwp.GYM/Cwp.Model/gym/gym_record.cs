using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    /// <summary>
    /// 健身房客户健身记录表
    /// </summary>
    public class gym_record
    {
        public Guid? id { get; set; }
        //健身房id
        public Guid? gymroomid { get; set; }
        public Guid? customerid { get; set; }
        public string start_date { get; set; }
        public string end_date { get; set; }
    }
}
