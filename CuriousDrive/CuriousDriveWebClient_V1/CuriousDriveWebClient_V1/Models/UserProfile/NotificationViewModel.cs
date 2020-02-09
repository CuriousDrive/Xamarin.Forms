using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class NotificationViewModel
    {
        public string isRead { get; set; }
        public string fromDisplayName { get; set; }
        public string fromURLTitle { get; set; }
        public string notificationHeader { get; set; }
        public string subsystemValue { get; set; }
        public string notificationDetail { get; set; }
        public int fromUserId { get; set; }
        public int referenceId { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
    }
}
