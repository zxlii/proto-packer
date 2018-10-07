using UnityEngine;
namespace WS.Data
{
    public sealed partial class Constance
    {

        private static Constance s_Instance;
        public static Constance Instance
        {
            get
            {
                if (s_Instance == null)
                {
                    var bytes = Resources.Load<TextAsset>("Constance").bytes;
                    s_Instance = Constance.Parser.ParseFrom(bytes);
                }
                return s_Instance;
            }
        }

        public void Initialize()
        {
            // 建议运行时做一次初始化讲数据放入内存，可以存成map方便读取
        }
        
        // 实现一些统一的数据获取方法
        public DataLevel GetLevelById(int id)
        {


            foreach (var itm in this.LevelList)
            {
                if (itm.Id == id)
                    return itm;
            }
            return null;
        }
    }
}