using System;
using System.IO;
using Zadanie03;

namespace Zadanie03
{
    public class FileStorage : IStore
    {
        public DirectoryInfo WorkingDirectory { get; private set; }
        
        public FileStorage(DirectoryInfo workingDirectory)
        {
            if (workingDirectory == null)
            {
                throw new ArgumentNullException("workingDirectory");
            }

            if (!workingDirectory.Exists)
            {
                throw new ArgumentNullException("Boo", "workingDirectory");
            }

            this.WorkingDirectory = workingDirectory;
        }

        public virtual bool Save(string path, string message)
        {
            File.WriteAllText(GetFileInfo(path).FullName, message);
            return GetFileInfo(path).Exists;
        }

        public virtual string Read(string path)
        {
            return File.ReadAllText(GetFileInfo(path).FullName);
        }

        public virtual FileInfo GetFileInfo(string name)
        {
            return new FileInfo(Path.Combine(WorkingDirectory.FullName, name + ".txt"));
        }
    }
}