using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class doTag
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int tagId { get; set; }
        public int userId { get; set; }
        public int userGroupTypeId { get; set; }
        public string userGroupTypeValue { get; set; }
        public string userGroupValue { get; set; }
        public int subsystemId { get; set; }
        public string subsystemValue { get; set; }
        public int subsystemReferenceId { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busTag : busBase
    {
        public doTag idoTag { get; set; }
        public string istrUserTag { get; set; }
    }
}
