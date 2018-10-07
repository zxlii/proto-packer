namespace WS.Data
{
    public sealed partial class DataPiece
    {
        public DataLevel GetLevel()
        {
            return Constance.Instance.GetLevelById(Id);
        }
    }
}