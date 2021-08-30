package org.example.mapper;

import org.example.domain.User;

/**
 * <pre>
 * userMapper
 * </pre>
 *
 * @author jiazhen.guo@meicloud.com
 * @version 1.00.00
 * @createDate 2021/8/30 15:17
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public interface UserMapper {

    User findUserById(Long id);
}
