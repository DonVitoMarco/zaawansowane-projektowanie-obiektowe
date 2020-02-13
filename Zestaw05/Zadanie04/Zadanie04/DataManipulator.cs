using System.IO;

namespace Zadanie04
{
    public class DataManipulator
    {
        private MessageStorage messageStorage;

        public DataManipulator(DirectoryInfo workingDirectory)
        {
            this.messageStorage = new MessageStorage(workingDirectory);
        }

        public virtual string Read(string path)
        {
            string message;
            messageStorage.Logger.LogMessage($"Readline message {path}.", 1);
            var file = messageStorage.Store.GetFileInfo(path);
            if (!file.Exists)
            {
                messageStorage.Logger.LogMessage($"No message {path} found.", 1);
                return "";
            }

            if (!messageStorage.Cache.Contains(path))
            {
                messageStorage.Cache.AddToCache(path, messageStorage.Store.Read(path));
            }

            message = messageStorage.Cache.GetMessageFromCache(path);
            
            messageStorage.Logger.LogMessage($"Returning message {path}.", 1);
            return message;
        }

        public virtual void Save(string path, string message)
        {
            messageStorage.Logger.LogMessage($"Saving message {path}.", 0);
            messageStorage.Store.Save(path, message);
            if (messageStorage.Cache.Contains(path))
            {
                messageStorage.Cache.WriteToCache(path, message);
            }
            else
            {
                messageStorage.Cache.AddToCache(path, message);
            }

            messageStorage.Logger.LogMessage($"Saving message {path}.", 0);
        }

    }
}