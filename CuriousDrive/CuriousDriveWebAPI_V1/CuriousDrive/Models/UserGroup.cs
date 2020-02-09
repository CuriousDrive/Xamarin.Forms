using System;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Models
{
    public partial class UserGroup
    {
        public UserGroup()
        {
            UserGroupDetail = new HashSet<UserGroupDetail>();
        }

        public int UserGroupId { get; set; }
        public string GroupName { get; set; }
        public string GroupDescription { get; set; }
        public int GroupStatusId { get; set; }
        public string GroupStatusValue { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public ICollection<UserGroupDetail> UserGroupDetail { get; set; }
    }
}
