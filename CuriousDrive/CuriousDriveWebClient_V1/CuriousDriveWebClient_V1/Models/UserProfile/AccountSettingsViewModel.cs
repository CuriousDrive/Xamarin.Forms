using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class AccountSettingsViewModel
    {
        public int userId { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string occupation { get; set; }
        public string aboutMe { get; set; }
        public string phoneNumber { get; set; }
        public string facebookUrl { get; set; }
        public string twitterUrl { get; set; }
        public string instagramUrl { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
    }
}
