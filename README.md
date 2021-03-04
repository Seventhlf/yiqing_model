# 病毒传播仿真程序
## 仿真场景
本程序模拟在400*  400范围内，初始时5000人中有10人感染病毒，其中当两人间距离小于6时可能感染病毒；当健康人被感染后，拥有一定潜伏期，当潜伏期过后入院；设有初始病床数，病人入院后即被隔离，无法感染他人，同时恢复率上升，死亡率下降；感染者恢复后不再感染病毒。所使用数据如下（数据来源于百度和适当优化调整）：  
  接触后感染率：0.25  
  戴口罩后感染率：0.1  
  限制出行后出门概率：0.5  
  恢复率：0.04  
  死亡率：0.01  
  入院后恢复率：0.08  
  入院后死亡率：0.005  
  普通病床数：50  
  增设病床后病床数：100  

## 程序设计
程序使用java语言编写，有三个类：  
- Yiqing类：用来设置初始项，例如是否佩戴口罩、是否限制出行、是否增设病床等，创建Ganran类实例；  
- People类：用来模拟每个人的情况，其中包括所处坐标、个人状态、病毒潜伏期等。个人状态分为易感者1、感染者2、死亡者3、住院隔离者4、恢复者0。模拟人员移动情况，使用rand.nextGaussian()生成平均值为0的double类随机数，加上坐标值来模拟移动后的坐标；  
- Ganran类：用来模拟每天人群移动后的疫情变化情况，判断易感者是否染病、感染者是否恢复或住院或死亡等。包括感染率为b，恢复率为c，死亡率为d，出门率为e。使用rand.nextDouble()生成0.0-1.0之间的double类随机数，若落在0-b*  e之间则感染且易感者与感染者距离小于6，若落在0-c则感染者恢复，若落在0-d则感染者死亡。潜伏期递减为0时入院，入院后不感染他人。  
  
运行逻辑：创建Ganran类实例，通过控制台输入初始化信息，调用Ganran类的change()方法，通过随机数创建5000人的People实例。在循环体内每循环一次便调用一次People类的move()方法，并判断是否感染、治愈或死亡等，以模拟每日疫情动态变化情况。每次循环都输出一次日期和当下疫情情况。当所有感染者都被隔离时疫情得到控制，当没有感染者时疫情结束，输出最终统计数据，程序运行结束。  

## 运行结果示例
![输入初始条件](https://github.com/Seventhlf/yiqing_model/blob/main/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C%E7%A4%BA%E4%BE%8B/%E6%95%B0%E6%8D%AE%E7%BB%9F%E8%AE%A1696.png)  
![运行过程中截图](https://github.com/Seventhlf/yiqing_model/blob/main/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C%E7%A4%BA%E4%BE%8B/%E6%95%B0%E6%8D%AE%E7%BB%9F%E8%AE%A1698.png)  
![运行结束后的输出](https://github.com/Seventhlf/yiqing_model/blob/main/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C%E7%A4%BA%E4%BE%8B/%E6%95%B0%E6%8D%AE%E7%BB%9F%E8%AE%A1700.png)  

## 结果分析：
结果分为五类：无任何防疫举措、仅佩戴口罩、仅限制出行、仅增设病床、采取所有防治措施。每一类分别运行五次，取平均值。数据如下（每部分最后一行为平均值）：  

<table width="480" border="0" cellpadding="0" cellspacing="0" style='width:288.00pt;border-collapse:collapse;table-layout:fixed;'>
   <col width="80" span="6" style='width:48.00pt;'/>
   <tr height="73.25" style='height:43.95pt;'>
    <td class="xl65" height="73.25" width="80" style='height:43.95pt;width:48.00pt;' x:str>共经历天数</td>
    <td class="xl66" width="80" style='width:48.00pt;' x:str>累计确诊人数</td>
    <td class="xl66" width="80" style='width:48.00pt;' x:str>未感染人数</td>
    <td class="xl66" width="80" style='width:48.00pt;' x:str>感染后恢复人数</td>
    <td class="xl66" width="80" style='width:48.00pt;' x:str>累计死亡人数</td>
    <td class="xl66" width="80" style='width:48.00pt;' x:str>第几天控制住疫情</td>
   </tr>
   <tr height="26.50" style='height:15.90pt;mso-height-source:userset;mso-height-alt:318;'>
    <td class="xl67" height="26.50" colspan="6" style='height:15.90pt;border-right:1.0pt solid windowtext;border-bottom:1.0pt solid windowtext;' x:str>无任何防疫举措</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>250</td>
    <td class="xl70" x:num>4238</td>
    <td class="xl70" x:num>762</td>
    <td class="xl70" x:num>3516</td>
    <td class="xl70" x:num>722</td>
    <td class="xl70" x:num>214</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>272</td>
    <td class="xl71" x:num>4472</td>
    <td class="xl71" x:num>528</td>
    <td class="xl71" x:num>3757</td>
    <td class="xl71" x:num>715</td>
    <td class="xl71" x:num>246</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>329</td>
    <td class="xl71" x:num>4275</td>
    <td class="xl71" x:num>725</td>
    <td class="xl71" x:num>3581</td>
    <td class="xl71" x:num>694</td>
    <td class="xl71" x:num>296</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>290</td>
    <td class="xl71" x:num>4415</td>
    <td class="xl71" x:num>585</td>
    <td class="xl71" x:num>3724</td>
    <td class="xl71" x:num>691</td>
    <td class="xl71" x:num>257</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>277</td>
    <td class="xl71" x:num>4470</td>
    <td class="xl71" x:num>530</td>
    <td class="xl71" x:num>3758</td>
    <td class="xl71" x:num>712</td>
    <td class="xl71" x:num>228</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl72" height="25.25" style='height:15.15pt;' x:num>283.6</td>
    <td class="xl73" x:num>4374</td>
    <td class="xl73" x:num>626</td>
    <td class="xl73" x:num>3667.2</td>
    <td class="xl73" x:num>706.8</td>
    <td class="xl73" x:num>248.2</td>
   </tr>
   <tr height="26.50" style='height:15.90pt;mso-height-source:userset;mso-height-alt:318;'>
    <td class="xl67" height="26.50" colspan="6" style='height:15.90pt;border-right:1.0pt solid windowtext;border-bottom:1.0pt solid windowtext;' x:str>仅戴口罩</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>84</td>
    <td class="xl70" x:num>82</td>
    <td class="xl70" x:num>4918</td>
    <td class="xl70" x:num>76</td>
    <td class="xl70" x:num>6</td>
    <td class="xl70" x:num>29</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>69</td>
    <td class="xl71" x:num>70</td>
    <td class="xl71" x:num>4930</td>
    <td class="xl71" x:num>64</td>
    <td class="xl71" x:num>6</td>
    <td class="xl71" x:num>33</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>69</td>
    <td class="xl71" x:num>59</td>
    <td class="xl71" x:num>4941</td>
    <td class="xl71" x:num>53</td>
    <td class="xl71" x:num>6</td>
    <td class="xl71" x:num>47</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>51</td>
    <td class="xl71" x:num>64</td>
    <td class="xl71" x:num>4936</td>
    <td class="xl71" x:num>59</td>
    <td class="xl71" x:num>5</td>
    <td class="xl71" x:num>32</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>49</td>
    <td class="xl71" x:num>31</td>
    <td class="xl71" x:num>4969</td>
    <td class="xl71" x:num>27</td>
    <td class="xl71" x:num>4</td>
    <td class="xl71" x:num>28</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl72" height="25.25" style='height:15.15pt;' x:num>64.4</td>
    <td class="xl73" x:num>61.2</td>
    <td class="xl73" x:num>4938.8</td>
    <td class="xl73" x:num>55.8</td>
    <td class="xl73" x:num>5.4</td>
    <td class="xl73" x:num>33.8</td>
   </tr>
   <tr height="26.50" style='height:15.90pt;mso-height-source:userset;mso-height-alt:318;'>
    <td class="xl67" height="26.50" colspan="6" style='height:15.90pt;border-right:1.0pt solid windowtext;border-bottom:1.0pt solid windowtext;' x:str>仅限制出行</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>68</td>
    <td class="xl70" x:num>110</td>
    <td class="xl70" x:num>4890</td>
    <td class="xl70" x:num>100</td>
    <td class="xl70" x:num>10</td>
    <td class="xl70" x:num>38</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>67</td>
    <td class="xl71" x:num>69</td>
    <td class="xl71" x:num>4931</td>
    <td class="xl71" x:num>64</td>
    <td class="xl71" x:num>5</td>
    <td class="xl71" x:num>42</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>108</td>
    <td class="xl71" x:num>138</td>
    <td class="xl71" x:num>4862</td>
    <td class="xl71" x:num>126</td>
    <td class="xl71" x:num>12</td>
    <td class="xl71" x:num>36</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>131</td>
    <td class="xl71" x:num>87</td>
    <td class="xl71" x:num>4913</td>
    <td class="xl71" x:num>79</td>
    <td class="xl71" x:num>8</td>
    <td class="xl71" x:num>46</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>103</td>
    <td class="xl71" x:num>134</td>
    <td class="xl71" x:num>4866</td>
    <td class="xl71" x:num>117</td>
    <td class="xl71" x:num>17</td>
    <td class="xl71" x:num>69</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl74" height="25.25" style='height:15.15pt;' x:num>95.4</td>
    <td class="xl75" x:num>107.6</td>
    <td class="xl75" x:num>4892.4</td>
    <td class="xl75" x:num>97.2</td>
    <td class="xl75" x:num>10.4</td>
    <td class="xl75" x:num>46.2</td>
   </tr>
   <tr height="26.50" style='height:15.90pt;mso-height-source:userset;mso-height-alt:318;'>
    <td class="xl67" height="26.50" colspan="6" style='height:15.90pt;border-right:1.0pt solid windowtext;border-bottom:1.0pt solid windowtext;' x:str>仅增设病床</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>116</td>
    <td class="xl70" x:num>188</td>
    <td class="xl70" x:num>4812</td>
    <td class="xl70" x:num>169</td>
    <td class="xl70" x:num>19</td>
    <td class="xl70" x:num>51</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>113</td>
    <td class="xl71" x:num>405</td>
    <td class="xl71" x:num>4595</td>
    <td class="xl71" x:num>369</td>
    <td class="xl71" x:num>36</td>
    <td class="xl71" x:num>88</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>178</td>
    <td class="xl71" x:num>527</td>
    <td class="xl71" x:num>4473</td>
    <td class="xl71" x:num>468</td>
    <td class="xl71" x:num>59</td>
    <td class="xl71" x:num>142</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>99</td>
    <td class="xl71" x:num>254</td>
    <td class="xl71" x:num>4746</td>
    <td class="xl71" x:num>230</td>
    <td class="xl71" x:num>24</td>
    <td class="xl71" x:num>85</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>122</td>
    <td class="xl71" x:num>851</td>
    <td class="xl71" x:num>4149</td>
    <td class="xl71" x:num>768</td>
    <td class="xl71" x:num>83</td>
    <td class="xl71" x:num>97</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl74" height="25.25" style='height:15.15pt;' x:num>125.6</td>
    <td class="xl75" x:num>445</td>
    <td class="xl75" x:num>4555</td>
    <td class="xl75" x:num>400.8</td>
    <td class="xl75" x:num>44.2</td>
    <td class="xl75" x:num>92.6</td>
   </tr>
   <tr height="26.50" style='height:15.90pt;mso-height-source:userset;mso-height-alt:318;'>
    <td class="xl67" height="26.50" colspan="6" style='height:15.90pt;border-right:1.0pt solid windowtext;border-bottom:1.0pt solid windowtext;' x:str>戴口罩、限制出行、增设病床</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>45</td>
    <td class="xl70" x:num>31</td>
    <td class="xl70" x:num>4969</td>
    <td class="xl70" x:num>29</td>
    <td class="xl70" x:num>2</td>
    <td class="xl70" x:num>29</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>58</td>
    <td class="xl71" x:num>31</td>
    <td class="xl71" x:num>4969</td>
    <td class="xl71" x:num>30</td>
    <td class="xl71" x:num>1</td>
    <td class="xl71" x:num>28</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>47</td>
    <td class="xl71" x:num>38</td>
    <td class="xl71" x:num>4962</td>
    <td class="xl71" x:num>34</td>
    <td class="xl71" x:num>4</td>
    <td class="xl71" x:num>32</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>64</td>
    <td class="xl71" x:num>31</td>
    <td class="xl71" x:num>4969</td>
    <td class="xl71" x:num>24</td>
    <td class="xl71" x:num>7</td>
    <td class="xl71" x:num>17</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl69" height="25.25" style='height:15.15pt;' x:num>41</td>
    <td class="xl71" x:num>21</td>
    <td class="xl71" x:num>4979</td>
    <td class="xl71" x:num>18</td>
    <td class="xl71" x:num>3</td>
    <td class="xl71" x:num>23</td>
   </tr>
   <tr height="25.25" style='height:15.15pt;'>
    <td class="xl72" height="25.25" style='height:15.15pt;' x:num>51</td>
    <td class="xl73" x:num>30.4</td>
    <td class="xl73" x:num>4969.6</td>
    <td class="xl73" x:num>27</td>
    <td class="xl73" x:num>3.4</td>
    <td class="xl73" x:num>25.8</td>
   </tr>
   <![if supportMisalignedColumns]>
    <tr width="0" style='display:none;'/>
   <![endif]>
  </table>

由以上表格清晰可见，无任何防疫举措和采取防疫举措差别巨大，且采取任何一种防疫措施效果均明显可见；戴口罩效果略优于限制出行，二者均明显优于增设病床，而增设病床亦可模拟医疗条件富足发达地区，因此在医疗条件富足发达地区倡导戴口罩和限制出行是有必要的。  
  
综上，对于防疫来说，佩戴口罩和限制出行是必不可少的，对于疫情严重地区增设病床隔离区可以有效降低确诊增长，对于医疗条件富足发达地区佩戴口罩和限制出行也是有必要的，可以显著控制疫情。
