package hwyoo.sample.spring.common.jpa.hibernate;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

/**
 * Created by hanwon.yoo on 2018. 8. 1..
 */
public class UnderScoreNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final long serialVersionUID = 2591415365733396596L;

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(addUnderScore(name.getText()), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier(addUnderScore(name.getText()), name.isQuoted());
    }

    protected static String addUnderScore(String name){
        StringBuilder buf = new StringBuilder(name.replace('.', '_'));

        for(int i = 1; i < buf.length() - 1; ++i) {
            if(Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i)) && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }

        return buf.toString().toLowerCase(Locale.ROOT);
    }
}
