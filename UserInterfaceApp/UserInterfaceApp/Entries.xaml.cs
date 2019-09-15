using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace UserInterfaceApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Entries : ContentPage
    {
        public Entries()
        {
            InitializeComponent();

            entAppName.Text = "Curious Drive";
        }

        private void Entry_Completed(object sender, EventArgs e)
        {
            lblCompleted.Text = ((Entry)sender).Text;
        }

        private void Entry_TextChanged(object sender, TextChangedEventArgs e)
        {
            lblEntryTextChangedOldValue.Text = e.OldTextValue;
            lblEntryTextChangedNewValue.Text = e.NewTextValue;
        }
    }
}