using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class doUserRole
    {
        public object istrMode { get; set; }
        public int iintUserId { get; set; }
        public int userRoleId { get; set; }
        public int userId { get; set; }
        public int roleId { get; set; }
        public string roleValue { get; set; }
        public int userGroupId { get; set; }
        public string userGroupValue { get; set; }
        public int createdBy { get; set; }
        public string createdDate { get; set; }
        public int modifiedBy { get; set; }
        public string modifiedDate { get; set; }
        public int updateSeq { get; set; }
        
    }
    public class busUserRole : busBase
    {
        public string istrUserGroup { get; set; }
        public doUserRole idoUserRole { get; set; }
    }
}