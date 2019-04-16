using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    //健身房设备
    public class gym_equipment
    {
        public Guid? id { get; set; }
        public Guid? gymroomid { get; set; }
        public string gymroomname { get; set; }
        public Guid? equipmentid { get; set; }
        public string equipmentname { get; set; }
        public string amount { get; set; }
        public string purchasetime { get; set; }
    }
}
