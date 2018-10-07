using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.IO;
using WS.Data;
public class Test : MonoBehaviour
{

    // Use this for initialization
    void Start()
    {
       
        Debug.Log(Constance.Instance.GetLevelById(11000440));
		

    }

    // Update is called once per frame
    void Update()
    {

    }
}
