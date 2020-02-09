using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Tag
    {
        public Tag()
        {
            TagDetail = new HashSet<TagDetail>();
        }

        public int TagId { get; set; }
        public int? UserGroupTypeId { get; set; }
        public string UserGroupTypeValue { get; set; }
        public int? UserGroupId { get; set; }
        public int? QuestionId { get; set; }
        public int? AnnouncementId { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? UpdateSeq { get; set; }

        public Announcement Announcement { get; set; }
        public Question Question { get; set; }
        public ICollection<TagDetail> TagDetail { get; set; }
    }
}
