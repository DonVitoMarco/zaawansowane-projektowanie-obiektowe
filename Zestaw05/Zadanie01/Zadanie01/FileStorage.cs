using System;
using System.IO;

namespace Zadanie01
{
    class FileStorage
    {
        private Logger Logger;
        private Cache Cacher;

        public DirectoryInfo WorkingDirectory { get; private set; }

        public FileStorage(DirectoryInfo workingDirectory)
        {
            Logger = new Logger();
            Cacher = new Cache();

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

        public void Save(string path, string message)
        {
            Logger.LogMessage($"Saving message {path}.", 0);
            var file = this.GetFileInfo(path);
            File.WriteAllText(file.FullName, message);
            if (Cacher.Contains(path))
            {
                Cacher.WriteToCache(path, message);
            }
            else
            {
                Cacher.AddToCache(path, message);
            }

            Logger.LogMessage($"Saving message {path}.", 0);
        }

        public string Read(string path)
        {
            string message;
            Logger.LogMessage($"Readline message {path}.", 1);

            var file = this.GetFileInfo(path);
            if (!file.Exists)
            {
                Logger.LogMessage($"No message {path} found.", 1);
                return "";
            }

            if (!Cacher.Contains(path))
            {
                Cacher.AddToCache(path, File.ReadAllText(file.FullName));
            }

            message = Cacher.GetMessageFromCache(path);
            ;
            Logger.LogMessage($"Returning message {path}.", 1);
            return message;
        }

        public FileInfo GetFileInfo(string name)
        {
            return new FileInfo(Path.Combine(WorkingDirectory.FullName, name + ".txt"));
        }
    }
}