package itfbstudy.bookservice.audit;

import itfbstudy.bookservice.enteties.Audit;
import itfbstudy.bookservice.enums.Reference;
import itfbstudy.bookservice.repository.AuditRepository;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Aspect
@Component
@Log4j2
public class AuditAspect {
    AuditRepository repository;
    public AuditAspect(AuditRepository repository){
        this.repository=repository;
    }
    @Pointcut("execution(* itfbstudy.*.controller..*(..))")
    public void auditAction(){
    }

    @Transactional
    @Before(value = "auditAction()")
    public void auditBefore(JoinPoint joinPoint) {
        audit(joinPoint,"START");
        System.out.println("Открытие транзакции...");
    }
    @Transactional
    @After(value = "auditAction()")
    public void auditAfter(JoinPoint joinPoint){
        audit(joinPoint,"CLOSED");
        System.out.println("Закрытие транзакции....");
    }
    @Transactional
    @AfterThrowing(value = "auditAction()")
    public void auditThrow(JoinPoint joinPoint) {
        audit(joinPoint,"ERROR");
        System.out.println("Операция не удалась, откат транзакции...");
    }
    private String getReturnClass(JoinPoint joinPoint){
        return ((MethodSignature) joinPoint.getSignature()).getReturnType().getSimpleName();
    }
    private void audit(JoinPoint joinPoint,String statusCode){
        Audit audit = new Audit(joinPoint.getSignature().getName(),
                //Reference.AuditStatus.START,
                Reference.AuditStatus.valueOf(statusCode),
                getReturnClass(joinPoint));
        repository.save(audit);
        log.info("Audit: "+audit.getId()+" save");
    }

//    @Around(value = "auditAction()")
//    public void beforeAdvice(ProceedingJoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature().getName());
//        System.out.println(((MethodSignature) joinPoint.getSignature()).getReturnType().getSimpleName());
//        System.out.println("Открытие транзакции...");
//        try {
//            joinPoint.proceed();
//            System.out.println("Закрытие транзакции....");
//        }
//        catch (Throwable throwable) {
//            System.out.println("Операция не удалась, откат транзакции...");
//        }
//    }

}
