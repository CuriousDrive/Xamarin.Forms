using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Input;
using Xamarin.Forms;

namespace UserInterfaceApp
{
    public class EnrollStudentViewModel : INotifyPropertyChanged
    {
        public ICommand SubmitCommand => new Command(Submit);

        public string FullName { get; set; }
        public string EmailAddress { get; set; }
        public bool IsForeign { get; set; }
        private string _displayMessage;
        public string DisplayMessage 
        
        { get { return _displayMessage; }
            set 
            {
                _displayMessage = value;
                OnPropertyChanged();
            } 
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public void Submit()       
        {
            DisplayMessage = this.FullName
                                    + ", we sent you email verification link on "
                                    + this.EmailAddress + ". Please verify your account.";
        }
    }
}
