using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class UserProfileCardViewModel
    {
        public string displayName { get; set; }
        public int userId { get; set; }
        public string urlTitle { get; set; }
        public string userGroup { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
    }
}
