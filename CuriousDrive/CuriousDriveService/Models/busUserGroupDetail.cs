using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class doUserGroupDetail
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int userGroupDetailId { get; set; }
        public int userGroupId { get; set; }
        public int userId { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }

    public class busUserGroupDetail : busBase
    {        
        public busUser ibusUser { get; set; }
        public doUserGroupDetail idoUserGroupDetail { get; set; }
    }
}
