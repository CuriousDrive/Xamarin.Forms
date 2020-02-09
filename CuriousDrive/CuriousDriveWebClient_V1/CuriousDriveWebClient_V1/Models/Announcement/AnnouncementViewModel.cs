using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebClient
{
    public class AnnouncementViewModel
    {
        public int announcementId { get; set; }
        public int userId { get; set; }
        public string announcementTitleURL { get; set; }
        public string announcementTitle { get; set; }
        public string announcementHtml { get; set; }
        public string displayName { get; set; }
        public string userURLTitle { get; set; }
        public UserTagViewModel userTagListViewModel { get; set; }
        public DateTime createdDate { get; set; }
        public UserDetailsViewModel userDetailsViewModel { get; set; }
        public bool isOwner { get; set; }
        public List<CommentViewModel> commentsViewModel { get; set; }
        public string announcementComment { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }

    }
}
