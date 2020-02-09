using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CuriousDriveService.Models
{
    public abstract class busBase
    {
        public List<busMessage> ilstbusMessages { get; set; }
        public bool isOwner { get; set; }

        public busBase()
        {
            ilstbusMessages = new List<busMessage>();
        }

        public void AddMessage(int aintMessageId)
        {
            ilstbusMessages.Add(new AdminService().GetMessage(aintMessageId));
        }
    }
}
