using System;
using System.IO;

namespace Zadanie03
{
    public class SqlStorage : IStore
    {
        public bool Save(string id, string message)
        {
            Console.WriteLine("Saved to db.");
            return true;
        }

        public string Read(string id)
        {
            Console.WriteLine("Read from db.");
            return "content";
        }

        public FileInfo GetFileInfo(string name)
        {
            throw new NotImplementedException();
        }
    }
}