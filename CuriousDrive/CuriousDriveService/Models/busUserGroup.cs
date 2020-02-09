using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public class doUserGroup
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int userGroupId { get; set; }
        public string groupName { get; set; }
        public string groupDescription { get; set; }
        public int groupStatusId { get; set; }
        public string groupStatusValue { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
    }    

    public class busUserGroup : busBase
    {
        public doUserGroup idoUserGroup { get; set; }
        public List<busUserGroupDetail> ilstUserGroupDetail { get; set; }
        public List<busUserGroup> ilstExistingUserGroups { get; set; }
        public string istrUserIds { get; set; }
        public String istrGroupStatusDescription { get; set; }
    }
}
