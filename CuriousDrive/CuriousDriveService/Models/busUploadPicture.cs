using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class busUploadPicture
    {
        public busUploadPicture(int aintUserId)
        {
            iintUserId = aintUserId;
        }

        public int iintUserId;
        public HttpPostedFileBase iImgPath;
    }

}