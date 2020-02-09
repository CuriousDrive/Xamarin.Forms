using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Text;
using System.Configuration;
using System.IO;
using System.Timers;

namespace WindowServiceFileWatcher
{
    public partial class WindowServiceFileWatcher : ServiceBase
    {
        Timer timer;
        public WindowServiceFileWatcher()
        {
            //InitializeComponent();
        }

        protected override void OnStart(string[] args)
        {
            try
            {
                timer = new Timer(100);
                timer.Elapsed += new ElapsedEventHandler(MoveFiles);
                timer.Enabled = true;
                
            }
            catch (Exception ex)
            {
                EventLog eventLog = new EventLog("Application");
                eventLog.Source = "Application";
                eventLog.WriteEntry(ex.Message, EventLogEntryType.Error, 101, 1);
            }
        }

        private void MoveFiles(object sender, ElapsedEventArgs elapsedEventArg)
        {
            string sourcePath;
            string targetPath;

            if (ConfigurationManager.AppSettings["Region"] == "DEV")
            {
                sourcePath = ConfigurationManager.AppSettings["sourcePath_DEV"];
                targetPath = ConfigurationManager.AppSettings["targetPath_DEV"];
            }
            else
            {
                sourcePath = ConfigurationManager.AppSettings["sourcePath_UAT"];
                targetPath = ConfigurationManager.AppSettings["targetPath_UAT"];
            }

            DirectoryInfo ldirInfo = new DirectoryInfo(sourcePath);
            FileInfo[] lstFileInfo = ldirInfo.GetFiles("*.jpg"); //getting all jpg files from the folder - 

            foreach (FileInfo file in lstFileInfo)
            {

                string destinationFile = targetPath + "\\" + file.Name;
                try
                {
                    if (File.Exists(destinationFile))
                        File.Delete(destinationFile);

                    File.Move(file.FullName, destinationFile);
                }
                catch (Exception ex)
                {
                    EventLog eventLog = new EventLog("Application");
                    eventLog.Source = "Application";
                    eventLog.WriteEntry(ex.Message, EventLogEntryType.Error, 101, 1);
                }
            }
        }

        protected override void OnStop()
        {
        }
    }
}
