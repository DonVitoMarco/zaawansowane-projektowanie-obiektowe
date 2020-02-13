using System;
using System.IO;

namespace Zadanie02
{
    public class FileStorage
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

        public virtual void Save(string path, string message)
        {
            File.WriteAllText(GetFileInfo(path).FullName, message);
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