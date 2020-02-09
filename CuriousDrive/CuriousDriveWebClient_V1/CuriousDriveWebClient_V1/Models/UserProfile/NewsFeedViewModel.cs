using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class NewsFeedViewModel
    {
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
        public string userName { get; set; }
        public string postType { get; set; }
        public string postTitle { get; set; }
        public string postTitleUrl { get; set; }
        public string createdDuration { get; set; }
        public int userId { get; set; }
        public int postId { get; set; }
    }
}
