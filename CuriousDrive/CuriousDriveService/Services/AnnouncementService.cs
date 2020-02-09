using System.Collections.Generic;
using CuriousDriveService.Models;
using CuriousDriveService.Global;

namespace CuriousDriveService
{
    public class AnnouncementService
    {
        busRestService ibusRestService = null;
        string modularUrl = "/announcements";

        public busAnnouncement InsertAnnouncement(busAnnouncement abusAnnouncement)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/announcements";
            return ibusRestService.Post<busAnnouncement>(modularUrl, abusAnnouncement);
        }

        public busAnnouncement UpdateAnnouncement(busAnnouncement abusAnnouncement)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/announcements/";
            modularUrl = modularUrl + abusAnnouncement.idoAnnouncement.announcementId;

            return ibusRestService.Post<busAnnouncement>(modularUrl, abusAnnouncement);
        }

        public busQuesitonView InsertAnnouncementView(int aintAnnouncementId, int aintUserId, string astrIPAddress, string astrBrowser)
        {
            //busQuesitonView lbusQuesitonView = new busQuesitonView { idoAnnouncementView = new doAnnouncementView() };
            //lbusQuesitonView.idoAnnouncementView.browser = astrBrowser;
            //lbusQuesitonView.idoAnnouncementView.ipAddress = astrIPAddress;
            //lbusQuesitonView.idoAnnouncementView.announcementId = aintAnnouncementId;
            //lbusQuesitonView.idoAnnouncementView.userId = aintUserId;

            //ibusRestService = new busRestService();
            //modularUrl = modularUrl + "/announcementViews";

            return null;//ibusRestService.Post<busQuesitonView>(modularUrl, lbusQuesitonView);
        }


        public busAnnouncement GetAnnouncement(int aintAnnouncementId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/announcements/" + aintAnnouncementId;

            return ibusRestService.Get<busAnnouncement>(modularUrl);
        }


        public List<busAnnouncement> GetAnnouncements()
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getAnnouncements";

            return ibusRestService.GetList<busAnnouncement>(modularUrl);
        }

        public busAnnouncement GetAnnouncementDetails(int aintAnnouncementId, int aintLoggedInUserId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/getAnnouncementDetails";
            modularUrl = modularUrl + "?aintAnnouncementId=" + aintAnnouncementId + "&aintLoggedInUserId=" + aintLoggedInUserId;

            return ibusRestService.Get<busAnnouncement>(modularUrl);
        }
        

        public busMessage DeleteAnnouncement(int aintAnnouncementId)
        {
            ibusRestService = new busRestService();
            modularUrl = modularUrl + "/announcements/";
            modularUrl = modularUrl + aintAnnouncementId;

            return ibusRestService.Delete<busMessage>(modularUrl);
        }
    
        public void UpdateAnnouncement(busAnnouncement abusAnnouncement, int aintUserId)
        {
            abusAnnouncement.idoAnnouncement.iintUserId = aintUserId;

            this.UpdateAnnouncement(abusAnnouncement);
        }

    }
}

