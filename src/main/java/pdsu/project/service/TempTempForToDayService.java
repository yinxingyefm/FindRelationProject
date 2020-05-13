package pdsu.project.service;

import pdsu.project.domain.TempTempForToDay;

/**
 * @author ljk
 * 分级接口
 */
public interface TempTempForToDayService {

    /***
     * *[分级]统计师生每天正常体温变化
     * @param role  当前人的角色
     *  当前查询人的学号/工号
     * @param
     * @return
     *   TempTempForToDay
     *  //不正常的数量
     *     private List<Integer> unnormal;
     *
     *     //正常的数量
     *     private List<Integer> normal;
     *     //时间
     *     private List<String> time;
     *
     */
    public TempTempForToDay selectAWeekforRole(String role) throws Exception;

}
