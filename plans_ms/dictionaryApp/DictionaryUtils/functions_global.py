from django.conf import settings
from rest_framework_simplejwt.backends import TokenBackend

class Functions_Global():
    def is_Authenticated(request):
        token = request.META.get('HTTP_AUTHORIZATION')[7:]
        tokenBackend = TokenBackend(algorithm=settings.SIMPLE_JWT['ALGORITHM'])
        valid_data = tokenBackend.decode(token,verify=False)
        return valid_data